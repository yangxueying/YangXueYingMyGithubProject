var _province = document.getElementById('province');
var _city = document.getElementById('city');
var _submit = document.getElementById('submit');
// banner图
// var mySwiper = new Swiper ('.swiper-container-top', {
//   // 如果需要前进后退按钮
//   nextButton: '.swiper-button-next',
//   prevButton: '.swiper-button-prev',
// })   
var mySwiper1 = new Swiper ('.swiper-container-banner', {
  // 如果需要前进后退按钮
  slidesPerView : 3,
  slidesPerGroup : 3,
  spaceBetween : 20,
  autoplay : 3000,
  speed:1000,
  loop: true,
  lazy: {
    loadPrevNext: true,
  },
  nextButton: '.swiper-button-next',
  prevButton: '.swiper-button-prev',
}); 
var mySwiper11 = new Swiper ('.swiper-container-banner-p', {
  // 如果需要前进后退按钮
  slidesPerView : 1,
  autoplay : 3000,
  speed:1000,
  loop: true,
  lazy: {
    loadPrevNext: true,
  },
  nextButton: '.swiper-button-next',
  prevButton: '.swiper-button-prev',
});   
var mySwiper2 = new Swiper('.swiper-container-daily',{
  pagination: '.swiper-pagination',
  nextButton: '.swiper-button-next',
  prevButton: '.swiper-button-prev',
  lazy: {
    loadPrevNext: true,
  },
});
var mySwiper22 = new Swiper('.swiper-container-daily-p',{
  pagination: '.swiper-pagination',
  nextButton: '.swiper-button-next',
  prevButton: '.swiper-button-prev',
  slidesPerView : 1.2,
  spaceBetween : 20,
  loop: true,
  centeredSlides: true,   
  lazy: {
    loadPrevNext: true,
  },
});
var mySwiper3 = new Swiper('.swiper-container-community',{
  nextButton: '.swiper-button-next',
  prevButton: '.swiper-button-prev',
  slidesPerView : 4,
  slidesPerGroup : 4,
  spaceBetween : 20,
  lazy: {
    loadPrevNext: true,
  },
});
$("aside span").on("click",function(){
  $(this).parent().hide();
});
$(".btn-close").on("click",function(){
  $(this).parent().parent().hide();
  $(".form-pettype select").val(0);
  $("#petname").val("");
  $("#province").val(110000);
  $("#city").empty();
  $("#city").prepend("<option value='110100'>北京市</option>");
  $("#city").val(110100);
  $("#startTime").val("");
  $("#endTime").val("");
  $("#phone").val("");
});
$(".family .banner-button-left").on("click",function(){
  $(".family .swiper-button-prev").click();
});
$(".family .banner-button-right").on("click",function(){
  $(".family .swiper-button-next").click();
});
$(".daily .banner-button-left").on("click",function(){
  $(".daily .swiper-button-prev").click();
});
$(".daily .banner-button-right").on("click",function(){
  $(".daily .swiper-button-next").click();
});
$(".community .community-btn-left").on("click",function(){
  $(".community .swiper-button-prev").click();
});
$(".community .community-btn-right").on("click",function(){
  $(".community .swiper-button-next").click();
});
// 日历
var e = ["日", "一", "二", "三", "四", "五", "六"]
  , a = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"];
$("#startTime").datepicker({
    dateFormat: "yy-mm-dd",
    dayNamesMin: e,
    monthNames: a,
    minDate: new Date,
    onSelect: function(t, i) {
        var n = new Date(t);
        n.setDate(n.getDate() + 1),
        $("#endTime").datepicker({
            dateFormat: "yy-mm-dd",
            dayNamesMin: e,
            monthNames: a,
            minDate: n
        })
    }
});
_submit.onclick = function(evt) {
  window.event ? window.event.returnValue = false : evt.preventDefault();
  window.event ? window.event.cancelBubble = true : evt.stopPropagation();
  var myreg=/^[1][3,4,5,7,8,9][0-9]{9}$/;  
  var e = {};
  e.petSize=0,e.isImmune = "0",e.isOestrus = "0",e.address = "新官网",e.petAge = "0",
  e.petGender = "0";
  if($("#phone").val()==""){
    alert("请输入电话号码");
    return false; 
  }
  if (!myreg.test($("#phone").val().trim())||$("#phone").val().length!=11) {  
    alert("请输入正确的11位电话号码");
    return false;  
  } 
  if($("#startTime").val()==""){
    alert("请选择寄养开始时间");
    return false; 
  }
  if($("#endTime").val()==""){
    alert("请选择寄养结束时间");
    return false; 
  }
  if($("#endTime").val()<$("#startTime").val()){
    alert("结束时间不能小于开始时间");
    return false;
  }
  if(_province.value==0){
    alert("请选择所在地区");
    return false;
  }
  if($(".form-pettype select").val()==0){
    alert("请选择宠物类型");
    return false;
  }
  if($("#petname").val()==''){
    alert("请填写宠物昵称");
    return false;
  }
  e.phone = $("#phone").val();
  e.fosterStartDate = $("#startTime").val();
  e.fosterEndDate = $("#endTime").val();
  e.regionId = _city.value;
  e.name= $("#petname").val();
  e.petName = $(".form-pettype select").val();
  $.ajax({
      type: "POST",
      dataType: "json",
      url: "/viptail/api/forms/saveFosterReservation",
      data: e,
      success: function(e) {
          0 == e.respCode ? ($('.cover').show()/*,$("#submit").html("预约成功")*/) : alert(e.respDesc)
      },
      error: function(e) {
          alert(e.respDesc)
      }
  });
}
/**
 * 省份改变事件
 */
var changeProvinceOption = function changeProvinceOption(_city, areaData) {
  var code = _province.value;
  var cityStr = '';
  var length = areaData.length;
  for (var i = 0; i < length; i++) {
    var value = areaData[i];
    if (value.pId && value.pId == code) {
      cityStr += '<option value="' + value.id + '">' + value.name + '</option>';
    }
  }
  _city.innerHTML = cityStr;
};
/**
 * 创建省份选择下拉列表
 * @param areaData
 */
var createAreaSelection = function createAreaSelection(areaData) {
  var princeStr = '';
  var length = areaData.length;
  for (var i = 0; i < length; i++) {
    var value = areaData[i];
    if (value.pId && value.pId == 1) {
      princeStr += '<option value="' + value.id + '">' + value.name + '</option>';
    }
  }
  _province.innerHTML = princeStr;
  changeProvinceOption(_city, areaData);
  //设置省份改变的事件
  _province.onchange = function(){
    changeProvinceOption(_city, areaData);
  };
};
$.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/viptail/api/forms/areaTreeData',
    success: function(res) {
        if (res.respCode == 0) {
          createAreaSelection(res.regionList);
        } else {
            console.log(res.respDesc)
        }
    }
})