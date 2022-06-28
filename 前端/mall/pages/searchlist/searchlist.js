// pages/searchlist/searchlist.js
import request from "../../util/request";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    goodList:[]
  },

  priceOrder:true,
  commentOrder:true,

  getList(categoryId) {
    request({
      url:`/good/searchByCategoryId/${categoryId}`
    }).then(res=>{
      console.log(res.data);
      this.setData({
        goodList:res.data
      });
    });
  },

  handleTap(evt) {
    wx.navigateTo({
      url: `/pages/detail/detail?goodId=${evt.currentTarget.dataset.goodid}&title=${evt.currentTarget.dataset.title}`,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
    wx.setNavigationBarTitle({
      title: options.title,
    });
    this.getList(options.categoryId);
  },

  handlePrice() {
    this.priceOrder = !this.priceOrder;
    this.setData({
      goodList:this.priceOrder?this.data.goodList.sort((item1,item2)=>item1.price-item2.price):this.data.goodList.sort((item1,item2)=>item2.price-item1.price)
    });
  },

  handleComment() {
    this.commentOrder = !this.commentOrder;
    this.setData({
      goodList:this.commentOrder?this.data.goodList.sort((item1,item2)=>parseInt(item1.goodComment)-parseInt(item2.goodComment)):this.data.goodList.sort((item1,item2)=>parseInt(item2.goodComment)-parseInt(item1.goodComment))
    });
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