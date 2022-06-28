function checkAuth(callback){
  if(wx.getStorageSync('tel')){
    callback();
  } else {
    if(wx.getStorageSync('token')) {
      wx.navigateTo({
        url: '/pages/telform/telform',
      });
    } else {
      wx.navigateTo({
        url: '/pages/auth/auth',
      })
    }
  }
}

export default checkAuth