/*多行文本控制*/
$(function() {
    $(".news-list li p").each(function() {
        var wareName = $(this);
        var wareNameText = wareName.html();
        var heightSome = wareName.height();
        getHeight()

        function getHeight() {
            if (heightSome > 60) {
                for (i = 0; heightSome > 60; i++) {
                    wareNameText = wareNameText.substring(0, wareNameText.length - 1);
                    wareName.html(wareNameText);
                    heightSome = wareName.height();
                }
                newText = wareNameText.substring(0, wareNameText.length - 1) + '...';
                wareName.html(newText);
            }
        }
    })
})
/*End 多行文本控制*/