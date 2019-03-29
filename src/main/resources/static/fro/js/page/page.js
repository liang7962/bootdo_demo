// JavaScript Document
(function($) {
  $.fn.myScroll = function(options) {
    //默认配置
    var defaults = {
      speed: 40, //滚动速度,值越大速度越慢
      rowHeight: 24 //每行的高度
    };

    var opts = $.extend({}, defaults, options),
      intId = [];

    function marquee(obj, step) {

      obj.find("ul").animate({
        marginTop: '-=1'
      }, 0, function() {
        var s = Math.abs(parseInt($(this).css("margin-top")));
        if (s >= step) {
          $(this).find("li").slice(0, 1).appendTo($(this));
          $(this).css("margin-top", 0);
        }
      });
    }

    this.each(function(i) {
      var sh = opts["rowHeight"],
        speed = opts["speed"],
        _this = $(this);
      intId[i] = setInterval(function() {
        if (_this.find("ul").height() <= _this.height()) {
          clearInterval(intId[i]);
        } else {
          marquee(_this, sh);
        }
      }, speed);

      _this.hover(function() {
        clearInterval(intId[i]);
      }, function() {
        intId[i] = setInterval(function() {
          if (_this.find("ul").height() <= _this.height()) {
            clearInterval(intId[i]);
          } else {
            marquee(_this, sh);
          }
        }, speed);
      });

    });

  }

})(jQuery);

/*End 文字滚动*/
/*标准规范tab切换*/
$(function() {
    $(".standard-tab li a").each(function(index) {
        $(this).click(function() {
            $(this).addClass("standard-hover").parent().siblings().find("a").removeClass("standard-hover");
            $(this).parents(".standard-msg").find(".standard-a").eq(index).show().siblings().hide();
        })
    });
});
/*End 标准规范tab切换*/
/*企业名录*/
$(function() {
    $(".exemleft-tag li a").each(function(index) {
        $(this).click(function() {
            $(this).addClass("exem-hover").parent().siblings().find("a").removeClass("exem-hover");
            $(this).parents(".exemplary-content").find(".exemplary-a").eq(index).show().siblings().hide();
        })
    });
});
/*End 企业名录*/