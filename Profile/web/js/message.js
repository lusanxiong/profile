var Message = {};
Message.text404 = "系统繁忙，请稍后在试！";
Message.text500 = "您已经退出登录，请重新登录！";
Message.text400 = "提交数据不完整！";
Message.text200 = "数据不存在！";
Message.text100 = "该信息已经被删除！";
Message.loading = "<img src='"+basePath+"/images/loading.gif' />正在加载，请稍候...";
Message.invalidFormat = "文件格式不正确！";
Message.shareImage = "分享图片";
Message.replyPrefix= "回复";


var Dialog = {};
Dialog.weibo = {};
Dialog.weibo.confirmTitle="删除微博";
Dialog.weibo.confirmContent='<span class="b large">确认删除该微博吗?</span><br /><span>若删除,该条微博的评论和回复将同时被删除。</span>';

Dialog.comment = {};
Dialog.comment.confirmTitle="删除评论";
Dialog.comment.confirmContent='<span class="b large">确认删除该评论吗?</span>';

Dialog.pm = {};
Dialog.pm.confirmTitle="刪除私信";
Dialog.pm.confirmContent='<span class="b large">确认删除该私信吗?</span>';

var Loading = {};
Loading.more = "更多";
Loading.over = "已完";