import request from "../../util/request";

// pages/telform/telform.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tel:""
  },

  formInputChange(evt){
    // console.log(evt.detail.value);
    this.setData({
      tel:evt.detail.value
    });
  },

  submitForm() {
    wx.setStorageSync('tel', this.data.tel);
    request({
      url:`/user/searchByTelAndNickname?tel=${this.data.tel}&nickname=${wx.getStorageSync('token').nickName}`
    }).then(res=>{
      console.log(res);
      if(res.data.length===0) {
        request({
          url:"/user/add",
          method:"POST",
          data:{
            ...wx.getStorageSync('token'),
            nickname:wx.getStorageSync('token').nickName,
            tel:this.data.tel
          }
        }).then(res=>{
          wx.navigateBack({
            delta: 2,
          });
        });
      }else{
        wx.navigateBack({
          delta: 2,
        });
      }
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