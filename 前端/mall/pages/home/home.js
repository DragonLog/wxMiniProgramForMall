// pages/home/home.js
import request from '../../util/request'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    loopList:[],
    goodList:[]
  },

  current:1,
  total:0,

  handleGet() {
    request({
      url:"/userTest/searchAll"
    }).then(res=>{
      console.log(res);
    });
  },

  handlePost() {
    request({
      url: '/userTest/add',
      method:"POST",
      data:{
        username:"ym",
        password:"123456"
      }
    }).then(res=>{
      console.log(res);
    });
  },

  handlePut() {
    request({
      url: '/userTest/change',
      method:"PUT",
      data:{
        userId:"22",
        username:"zcx",
        password:"888888"
      },
    }).then(res=>{
      console.log(res);
    });
  },

  handleDelete() {
    request({
      url: '/userTest/remove/22',
      method:"DELETE",
    }).then(res=>{
      console.log(res);
    });
  },

  renderSwiper() {
    request({
      url:'/carousel/searchAll'
    }).then(res=>{
      console.log(res.data);
      this.setData({
        loopList:res.data
      });
    });
  },

  renderGoods() {
    request({
      url:`/good/searchPage?current=${this.current}&size=5`
    }, true).then(res=>{
      console.log(res.list);
      this.total = Number(res.total);
      this.setData({
        goodList:[...this.data.goodList,...res.list]
      });
    });
  },

  handleEvent() {
    wx.navigateTo({
      url: '/pages/search/search',
    })
  },

  handleChangePage(evt) {
    // console.log(evt.currentTarget.dataset.id);
    var goodId = evt.currentTarget.dataset.goodid;
    var title = evt.currentTarget.dataset.title;
    wx.navigateTo({
      url: `/pages/detail/detail?goodId=${goodId}&title=${title}`
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.renderSwiper();
    this.renderGoods();
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
    if (this.data.goodList.length===this.total) {
      return;
    }
    this.current++;
    this.renderGoods();
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})