var Blue = Blue || {}

Blue.Menu = (function() {

   function Menu() {}
     
   Menu.prototype.iniciar = function() {      
	  var urlAtual = window.location.href;
       montaMenu(urlAtual);
   }

   function montaMenu(urlAtual) {
	   
	   $.each( $('.aw-menu__item'), function() {
		   
		   var menuItem = $(this);
		   var urlItem = menuItem.find('a').attr('href');
		   
		   if(urlAtual.search(urlItem) > 0) {
			   menuItem.addClass('is-active');
			   var elementoPai = menuItem.parent().parent();
			   
			   if(elementoPai[0] != $('nav.aw-menu.js-menu')[0]) {
				   elementoPai.addClass('is-expanded is-active');
			   }
		   }
		   
	   });
   }
   
   return Menu;

}());

$(function() {

   var menu = new Blue.Menu();
   menu.iniciar();

});
