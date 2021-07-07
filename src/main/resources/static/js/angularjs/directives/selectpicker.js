'use strict';

angular.module('edms').directive('selectpicker', function() {
	return {
        restrict: 'A',
        scope: {
            ngModel: '=',
        },
        link: function (scope, element, attrs, ngModelCtrl) {
            console.log("selectpicker");
            element.selectpicker();
            setTimeout(function () {
                element.selectpicker('refresh');
                element.selectpicker('val', scope.ngModel);
            }, 200);

            element.on('shown.bs.select', function (e, clickedIndex, isSelected, previousValue) {
                setTimeout(function () { $(".multi-select-dropdown input[type=search]").focus(); }, 10);
            });


		}
	};
});