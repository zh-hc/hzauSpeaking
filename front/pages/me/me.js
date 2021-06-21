//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    list: {
      "nickName": '',
      "gender": '',
      "city": '',
      "province": '',
      "country": '',
      "avatarUrl": ''
    },
    // 组件所需的参数
    nvabarData: {
      showCapsule: 0, //是否显示左上角图标   1表示显示    0表示不显示
      title: '我的', //导航栏 中间的标题
      height: 0
    },
    userId: "-1",
    message: {},
    userInfo: {},
    showDialog1: false,
    // 此页面 页面内容距最顶部的距离
    height: app.globalData.height * 2 + 20,
    isLoading: false
  },
  onLoad() {
    this.setData({
      height: app.globalData.height
    })
    var that = this
    wx.getStorage({
      key: 'userId',
      success: function (res) {
        that.setData({
          userId: res.data
        })
      },
      fail: function () {
        if (that.data.userId == -1) {
          that.setData({
            showDialog1: true
          })
        }
      }
    })
    wx.getStorage({
      key: 'userInfo',
      success: function (res) {
        that.setData({
          userInfo: res.data
        })
      },
      fail: function () {
        if (that.data.userId == -1) {
          that.setData({
            showDialog1: true
          })
        }
      }
    })
    that.setData({
      userInfo: getApp().globalData.userInfo,
      userId: getApp().globalData.userId
    })
  },
  checkAdmin() {
    let that = this
    wx.request({
      url: getApp().globalData.url + '/checkAdmin?id=' + new Number(that.data.userId),
      method: "get",
      success: function (res) {
        if (res.data[0].userIsAdmin != 2) {
          wx.showModal({
            title: '提示',
            content: '还未获得权限，请联系管理员',
          })
        }
        if (res.data[0].userIsAdmin == 2) {
          wx.showModal({
            title: '提示',
            content: '已获得管理员权限',
          })
        }
        wx.setStorage({
          key: 'userIsAdmin',
          data: res.data[0].userIsAdmin,
        })
        getApp().globalData.userIsAdmin = res.data[0].userIsAdmin
      }
    })
  },

  getUserProfile() {
    let that = this
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认
    // 开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        // that.data.userInfo = res.userInfo;
        that.data.userInfo = res.userInfo;
        console.log(that.data.userInfo);
        this.getUser();
        // this.setData({
        //   userInfo: res.userInfo,
        //   // hasUserInfo: true
        // })
      }
    })
  },

  getUser() {
    var that = this
    var list = {
      "nickName": this.data.userInfo.nickName,
      "gender": this.data.userInfo.gender,
      "city": this.data.userInfo.city,
      "province": this.data.userInfo.province,
      "country": this.data.userInfo.country,
      "avatarUrl": this.data.userInfo.avatarUrl
    }
    var listMessage = {
      "userAvatar": this.data.userInfo.avatarUrl,
      "userNickname": this.data.userInfo.nickName,
      "userGender": this.data.userInfo.gender,
    }
    wx.login({
      success: function (res) {
        wx.showLoading({
          title: '登陆中~',
        })
        // 获取登录的临时凭证
        var code = res.code;
        // 调用后端，获取微信的session_key, secret
        wx.request({
          url: getApp().globalData.url + "/Login?code=" + code,
          method: "POST",
          data: JSON.stringify(listMessage),
          dataType: JSON,
          success: function (result) {
            wx.hideLoading();
            if (result.statusCode != 200) {
              console.log(result)
              wx.showModal({
                title: '提示',
                content: '出现问题啦，在试一下吧~',
              })
              return;
            }
            that.setData({
              message: JSON.parse(result.data),
              userInfo: list,
            })
            wx.setStorage({
              key: 'userId',
              data: that.data.message.userId,
            })
            wx.setStorage({
              key: 'userInfo',
              data: list,
            })

            getApp().globalData.userId = that.data.message.userId

            getApp().globalData.userInfo = list


            if (that.data.message.code === 200) {
              wx.showModal({
                title: '提示',
                content: '欢迎回来，老朋友~',
              })
            }
            if (that.data.message.code === 300) {
              wx.showModal({
                title: '提示',
                content: '你好新朋友，快去探索吧~',
              })
            }
            console.log(that.data.showDialog1);
            that.setData({
              showDialog1: false
            })
          }
        })
      }
    })
  },

  doLogin() {

    var that = this

    var list = {
      "nickName": this.data.userInfo.nickName,
      "gender": this.data.userInfo.gender,
      "city": this.data.userInfo.city,
      "province": this.data.userInfo.province,
      "country": this.data.userInfo.country,
      "avatarUrl": this.data.userInfo.avatarUrl
    }

    var listMessage = {
      "userAvatar": this.data.userInfo.avatarUrl,
      "userNickname": this.data.userInfo.nickName,
      "userGender": this.data.userInfo.gender,
    }
    console.log(listMessage);
    wx.login({
      success: function (res) {
        wx.showLoading({
          title: '登陆中~',
        })
        // console.log(that.data.openid)
        // 获取登录的临时凭证
        var code = res.code;
        // 调用后端，获取微信的session_key, secret
        wx.request({
          url: getApp().globalData.url + "/Login?code=" + code,
          method: "POST",
          data: JSON.stringify(listMessage),
          dataType: JSON,
          success: function (result) {
            wx.hideLoading();
            if (result.statusCode != 200) {
              console.log(result)
              wx.showModal({
                title: '提示',
                content: '出现问题啦，在试一下吧~',
              })
              return;
            }
            that.setData({
              message: JSON.parse(result.data),
              userInfo: list,
            })
            wx.setStorage({
              key: 'userId',
              data: that.data.message.userId,
            })
            wx.setStorage({
              key: 'userInfo',
              data: list,
            })

            getApp().globalData.userId = that.data.message.userId

            getApp().globalData.userInfo = list


            if (that.data.message.code === 200) {
              wx.showModal({
                title: '提示',
                content: '欢迎回来，老朋友~',
              })
            }
            if (that.data.message.code === 300) {
              wx.showModal({
                title: '提示',
                content: '你好新朋友，快去探索吧~',
              })
            }
            console.log(that.showDialog1);
            that.setData({
              showDialog1: false
            })
          }
        })
      }
    })
  },
  onReady() {
    let that = this
    setTimeout(function () {
      that.setData({
        isLoading: true
      })
    }, 500)
  },

  attention() {
    wx.showModal({
      title: '提示',
      content: '公众号名称  小白的号',
      confirmText: "复制",
      showCancel: false,
      success: function () {
        wx.setClipboardData({
          data: '小白的号',
        })
      }
    })
  },
  call() {
    wx.showModal({
      title: '提示',
      content: '微信联系/手机联系',
      confirmText: "手机联系",
      confirmColor: "#3cc",
      cancelColor: "#3cc",
      cancelText: "微信联系",
      success: function (e) {
        if (e.confirm) {
          wx.showModal({
            title: '提示',
            content: '是否联系(18264518955)',
            success: function (e) {
              if (e.confirm) {
                wx.makePhoneCall({
                  phoneNumber: '18264518955',
                })
              }
            }
          })
        } else {
          wx.showModal({
            title: '提示',
            content: '微信号：18264518955',
            confirmText: "复制",
            success: function (e) {
              if (e.confirm) {
                wx.setClipboardData({
                  data: '18264518955',
                })
              }
            }
          })
        }
      }
    })
  },
  onShow() {
    let that = this
    this.setData({
      userId: getApp().globalData.userId
    })
    wx.getStorage({
      key: 'userId',
      success: function (res) {
        that.setData({
          userId: res.data
        })
      },
    })
  }
})