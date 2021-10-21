/*
	Axiom by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
*/

(function($) {

	var	$window = $(window),
		$body = $('body');

	// Breakpoints.
		breakpoints({
			normal:     [ '1081px',  '1280px' ],
			narrow:     [ '961px',   '1080px' ],
			narrower:   [ '737px',   '960px'  ],
			mobile:     [ null,      '736px'  ]
		});

	// Play initial animations on page load.
		$window.on('load', function() {
			window.setTimeout(function() {
				$body.removeClass('is-preload');
			}, 100);
		});

	// Dropdowns.
		$('#nav > ul').dropotron({
			alignment: 'center',
			noOpenerFade: true
		});

	// Slider
		var $slider = $('#slider');
		if ($slider.length > 0) {

			$slider.slidertron({
				mode: 'fade',
				viewerSelector: '.viewer',
				reelSelector: '.viewer .reel',
				slidesSelector: '.viewer .reel .slide',
				advanceDelay: 3000,
				speed: 'slow',
				navPreviousSelector: '.previous-button',
				navNextSelector: '.next-button',
				slideLinkSelector: '.link',
				autoFit: true,
				seamlessWrap: false
			});

			$window
				.on('resize load', function() {
					$slider.trigger('slidertron_reFit');
				})
				.trigger('resize');

		}

	// Nav Panel.

		// Title Bar.
			$(
				'<div id="titleBar">' +
					'<a href="#navPanel" class="toggle"></a>' +
				'</div>'
			)
				.appendTo($body);

		// Panel.
			$(
				'<div id="navPanel">' +
					'<nav>' +
						$('#nav').navList() +
					'</nav>' +
				'</div>'
			)
				.appendTo($body)
				.panel({
					delay: 500,
					hideOnClick: true,
					hideOnSwipe: true,
					resetScroll: true,
					resetForms: true,
					side: 'left',
					target: $body,
					visibleClass: 'navPanel-visible'
				});

})(jQuery);