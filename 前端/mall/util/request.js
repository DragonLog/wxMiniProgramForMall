function request(params,isHeader=false) {
  return new Promise((resolve, reject)=>{
    wx.showLoading({
      title: '正在加载中',
    })
    wx.request({
      ...params,
      url: 'http://localhost:8080/' + params.url,
      success:(res)=>{
        if(isHeader) {
          resolve({
            list:res.data.data,
            total:res.header["X-Total-Count"]
          });
        } else {
          resolve(res.data);
        }
      },
      fail:(err)=>{
        reject(err);
      },
      complete:()=>{
        wx.hideLoading({
          success: (res) => {},
        })
      }
    })
  });
}

export default request