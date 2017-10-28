var AW = AW || {};

AW.onSidebarToggleRequest = function(event) {
  event.preventDefault();
  $(this).blur();

  $('.js-sidebar, .js-content').toggleClass('is-toggled');
};

AW.onMenuGroupClick = function(event) {
  var subItems = $(this).parent().find('ul');

  if (subItems.length) {
    event.preventDefault();
    $(this).parent().toggleClass('is-expanded'); 
  }
};

AW.ActiveMenu = function() {
	
	var urlAtual = window.location.href;
	
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
	
};

AW.initMenu = function() {
  $('.js-menu > ul > li > a').bind('click', AW.onMenuGroupClick);
  //$('.aw-menu__item .is-active').parents('.aw-menu__item').addClass('is-expanded is-active');
  
  AW.ActiveMenu();
};


$(function() {
  if (AW.init) {
    AW.init();
  }

  AW.initMenu();
 
  // Bind events
  $('.js-sidebar-toggle').bind('click', AW.onSidebarToggleRequest);
  $('.js-search-modal-trigger-show').bind('click', AW.onSearchModalShowRequest);
  $('.js-search-modal-close').bind('click', AW.onSearchModalCloseRequest);
});