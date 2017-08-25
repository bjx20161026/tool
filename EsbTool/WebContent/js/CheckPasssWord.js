function loginCheck(){
var name = document.getElementById("name").value;
var password = document.getElementById("password").value;
var respon;
var myurl = "http://localhost:9180/EsbTool/rest/login/getPassword?name="+name+"&password="+password;
//先声明一个异步请求对象
var xmlHttpReg = null;
if (window.ActiveXObject) {//如果是IE
    xmlHttpReg = new ActiveXObject("Microsoft.XMLHTTP");
} else if (window.XMLHttpRequest) {
    xmlHttpReg = new XMLHttpRequest(); //实例化一个xmlHttpReg
}
//如果实例化成功,就调用open()方法,就开始准备向服务器发送请求
if (xmlHttpReg != null) {
    xmlHttpReg.open("get", myurl, true);
    xmlHttpReg.send(null);
    xmlHttpReg.onreadystatechange = doResult; //设置回调函数
}
//回调函数
//一旦readyState的值改变,将会调用这个函数,readyState=4表示完成相应
//设定函数doResult()
function doResult() {
    if (xmlHttpReg.readyState == 4) {//4代表执行完成
        if (xmlHttpReg.status == 200) {//200代表执行成功
            //将xmlHttpReg.responseText的值赋给ID为resText的元素
            respon = xmlHttpReg.responseText;  
            if(respon==1){
            	setCookie('esbTool','1','d1')
            	window.location.href="html/homepage.html";
            	}else{
            	alert("用户名密码错误！\r"+"用户名:"+name+"\r"+"密码:"+password);
            	}
        }
    }
}
}
function setCookie(name,value,time)
{
var strsec = getsec(time);
var exp = new Date();
exp.setTime(exp.getTime() + strsec*1);
document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
function getsec(str)
{
var str1=str.substring(1,str.length)*1;
var str2=str.substring(0,1);
if (str2=="s")
{
return str1*1000;
}
else if (str2=="h")
{
return str1*60*60*1000;
}
else if (str2=="d")
{
return str1*24*60*60*1000;
}
}