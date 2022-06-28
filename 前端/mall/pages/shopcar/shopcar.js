// pages/shopcar/shopcar.js
import checkAuth from "../../util/auth";
import request from "../../util/request";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    slideButtons:[{
      type:'warn',
      text:'删除'
    }],
    cartList:[]
  },

  slideButtonTap(evt) {
    console.log(evt.currentTarget.dataset.cartid);
    var cartId = evt.currentTarget.dataset.cartid;
    this.setData({
      cartList:this.data.cartList.filter(item=>item.cartId!==cartId)
    });
    request({
      url:`/cart/remove/${cartId}`,
      method:"DELETE"
    });
  },

  handleTap(evt){
    var item = evt.currentTarget.dataset.item;
    item.checked = !item.checked;
    this.handleUpdate(item);
  },

  handleUpdate(item) {
    this.setData({
      cartList:this.data.cartList.map(data=>{
        if(data.cartId===item.cartId) {
          return item;
        }
        return data;
      })
    });
    request({
      url:"/cart/change",
      method:"PUT",
      data:{
        "cartId":item.cartId,
        "nickname":item.nickname,
        "tel":item.tel,
        "goodId":item.goodId,
        "number":item.number,
        "checked":item.checked
      }
    });
  },

  handleMinus(evt){
    var item = evt.currentTarget.dataset.item;
    if(item.number===1){
      return;
    }
    item.number--;
    this.handleUpdate(item);
  },

  handleAdd(evt){
    var item = evt.currentTarget.dataset.item;
    item.number++;
    this.handleUpdate(item);
  },

  handleAllChecked(evt) {
    var cartIdsMap = this.data.cartList.map(item=>({
      cartId:item.cartId
    }));
    var cartIds = [];
    for (var i = 0; i < cartIdsMap.length; i ++){
      cartIds.push(cartIdsMap[i].cartId);
    }
    if(evt.detail.value.length===0) {
      this.setData({
        cartList:this.data.cartList.map(item=>({
          ...item,
          checked:false
        }))
      });
      request({
        url:"/cart/changeCheckedToFalse",
        method:"PUT",
        data:{
          "cartIds":cartIds
        }
      });
    } else {
      this.setData({
        cartList:this.data.cartList.map(item=>({
          ...item,
          checked:true
        }))
      });
      request({
        url:"/cart/changeCheckedToTrue",
        method:"PUT",
        data:{
          "cartIds":cartIds
        }
      });
    }
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
    checkAuth(()=>{
      // console.log("显示购物车");
      let {nickName} = wx.getStorageSync('token');
      let tel = wx.getStorageSync('tel');
      request({
        url:`/cart/searchByNicknameAndTel?nickname=${nickName}&tel=${tel}`
      }).then(res=>{
        console.log(res);
        this.setData({
          cartList:res.data
        });
      });
     });
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