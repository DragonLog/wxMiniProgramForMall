import checkAuth from "../../util/auth";
import request from "../../util/request";

// pages/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    info:null,
    current:0,
    commentList:[]
  },

  getDetailInfo(goodId) {
    request({
      url:`/good/search/${goodId}`
    }).then(res=>{
      console.log(res.data);
      this.setData({
        info:res.data
      });
    });
  },

  handleTap(evt) {
    wx.previewImage({
      current:evt.currentTarget.dataset.current,
      urls:this.data.info.slides.map(item=>`http://localhost:8080/${item}`)
    })
  },

  handleActive(evt) {
    this.setData({
      current:evt.currentTarget.dataset.index
    });
  },

  getCommentInfo() {
    request({
      url:"/comment/searchAll"
    }).then(res=>{
      console.log(res.data);
      this.setData({
        commentList:res.data
      });
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: options.title
    });
    this.getDetailInfo(options.goodId);
    this.getCommentInfo();
  },

  handleAdd() {
    checkAuth(()=>{
      console.log("准备加入购物车");
      let {nickName} = wx.getStorageSync('token');
      let tel = wx.getStorageSync('tel');
      var goodId = this.data.info.goodId;
      // console.log(nickName, tel, goodId);
      request({
        url:`/cart/searchByTelAndGoodIdAndNickname?nickname=${nickName}&tel=${tel}&goodId=${goodId}`
      }).then(res=>{
        console.log(res);
        if(res.data.length===0) {
          return request({
            url:"/cart/add",
            method:"POST",
            data:{
              "nickname":nickName,
              "tel":tel,
              "goodId":goodId,
              "number":1,
              "checked":false
            }
          });
        } else {
          return request({
            url:"/cart/change",
            method:"PUT",
            data:{
              ...res.data[0],
              number:res.data[0].number+1,
            }
          });
        }
      }).then(res=>{
        wx.showToast({
          title: '加入购物车成功',
        })
      });
    });
  },

  handleChange(){
    wx.switchTab({
      url: '/pages/shopcar/shopcar',
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})