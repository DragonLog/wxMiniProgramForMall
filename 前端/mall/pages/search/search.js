import request from "../../util/request";

// pages/search/search.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  search: function(value) {
    return Promise.all([
      request({
        url:`/category/searchLike?title=${value}`
      }),
      request({
        url:`/good/searchLike?title=${value}`
      }),
    ]).then(res=>{
      return ([...res[0].data.map(item=>({
        ...item,
        text:item.title,
        type:1
      })), ...res[1].data.map(item=>({
        ...item,
        text:item.title,
        type:2
      }))]);
    });
  },

  selectResult: function(e) {
    console.log('select result', e.detail);
    if (e.detail.item.type===1) {
      wx.navigateTo({
        url: `/pages/searchlist/searchlist?categoryId=${e.detail.item.categoryId}&title=${e.detail.item.title}`,
      })
    }else{
      wx.navigateTo({
        url: `/pages/detail/detail?goodId=${e.detail.item.goodId}&title=${e.detail.item.title}`,
      });
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      search: this.search.bind(this)
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