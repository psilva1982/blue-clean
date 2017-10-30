var Blue = Blue || {}	//Se não existir cria um novo objeto Blue

Blue.MaskMoney = (function(){
	
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain'); 
	}
	
	MaskMoney.prototype.enable = function() {
		// Mask com .jquery.maskmoney
		//this.decimal.maskMoney({decimal: ',', thousands: '.'});
		//this.plain.maskMoney({precision: 0, thousands: '.'});

		this.decimal.maskNumber({decimal: ',', thousands: '.'});
		this.plain.maskNumber({integer: true, thousands: '.'});
		
	}
	
	return MaskMoney; 
	
}());

$(function() {
	
	var maskMoney = new Blue.MaskMoney();
	maskMoney.enable();

});