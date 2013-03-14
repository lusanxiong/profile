/**
 * 话题替换 唐高红 version 1.0
 */
(function($) {
	$.fn.extend( {
		topic : function() {
			var myValue = "#请在这里输入自定义话题#";
			var txt = $(this).val();
			var $t = $(this)[0];
			var index = txt.indexOf(myValue);
			if (index >= 0) {
				var len = txt.length;
				var start = index + 1;
				var end = (index + 12) - len;

				if ($.browser.msie) {// IE
				var range = $t.createTextRange();
				range.moveStart("character", start);
				range.moveEnd("character", end);
				range.select();
				return;
			} else { // !IE
				$t.setSelectionRange(start, start + 11);
				$t.focus();
				return;
			}
		}
		if (document.selection) { // IE
			this.focus();
			sel = document.selection.createRange();
			sel.text = myValue;

			var t = $(this).val();
			var index = t.indexOf(myValue);

			var len = t.length;
			var start = index + 1;
			var end = (index + 12) - len;
			var range = $t.createTextRange();
			range.moveStart("character", start);
			range.moveEnd("character", end);
			range.select();
			return;
		} else if ($t.selectionStart || $t.selectionStart == '0') { // !IE
			var startPos = $t.selectionStart;
			var endPos = $t.selectionEnd;
			var scrollTop = $t.scrollTop;
			$t.value = $t.value.substring(0, startPos) + myValue
					+ $t.value.substring(endPos, $t.value.length);
			$t.setSelectionRange(startPos + 1, startPos + 12);
			$t.focus();
		} else {
			this.value += myValue;
			this.focus();
		}
	}
})
})(jQuery);