var tOrigin = $("#textarea-origin");
var tResult = $("#textarea-result");
var hintNoText = $("#hint-no-text");
var hintError = $("#hint-error");
var hintSuccess = $("#hint-success");
var hintCharsetOrigin = $('#hint-charset-origin');
var hintCharsetTarget = $('#hint-charset-target');


$("#btn-correct").click(function () {

    hintNoText.hide();
    hintError.hide();
    hintSuccess.hide();

    if (!tOrigin.val()) {
        hintNoText.show(50);
        return;
    }

    if (tOrigin.val().length > 65535) {
        hintError.html("最大支持65535个字符，当前" + tOrigin.val().length + "个字符");
        hintError.show();
        return;
    } else {
        hintError.html("失败");
    }

    $.post('/correct', {s: tOrigin.val()}, function (r) {
        tResult.val((r.data && r.data.result) ? r.data.result : '');
        hintCharsetOrigin.hide();
        if (r.data.originCharset) {
            hintCharsetOrigin.html(r.data.originCharset);
            hintCharsetOrigin.show(50);
        }
        hintCharsetTarget.hide();
        if (r.data.resultCharset) {
            hintCharsetTarget.html(r.data.resultCharset);
            hintCharsetTarget.show(50);
        }

        if (r.success) {
            hintSuccess.show(50);
        } else {
            hintError.html(r.error ? r.error : '失败');
            hintError.show(50);
        }
    })

});