'use strict';

angular.module('edms').directive('intltel', function() {
	var errorMap = [
		"intl_tel_invalid_number",
		"intl_tel_invalid_country_code",
		"intl_tel_too_short",
		"intl_tel_too_long",
		"intl_tel_invalid_number"
	];

	return {
		require: 'ngModel',
		link: function(scope, elem, attr, ngModel) {
			scope.disclosure.contactPhoneIso2 = "bd";
			var iti = window.intlTelInput(document.querySelector("#" + $(elem).attr('id')), {
				utilsScript: "/js/external/telinput/utils.js",
				initialCountry: scope.disclosure.contactPhoneIso2,
				formatOnDisplay: false
			});

			attr.$observe('intltel', function(actual_value) {
				scope.disclosure.contactPhoneIso2 = (actual_value === undefined || actual_value === null || actual_value === '') ? 'bd' : actual_value;
				iti = window.intlTelInput(document.querySelector("#" + $(elem).attr('id')), {
					utilsScript: "/js/external/telinput/utils.js",
					initialCountry: actual_value,
					formatOnDisplay: false
				});
			});

			//For DOM -> model validation
			ngModel.$parsers.unshift(function(value) {

				for(var i=0; i<=4; i++) {
					ngModel.$setValidity(errorMap[i], true);
				}

				var valid = iti.isValidNumber();
				if(!valid) {
					var errorCode = iti.getValidationError();
					errorCode = errorCode == -99 ? 0 : errorCode;
					console.log("ec: " + errorCode);
					ngModel.$setValidity(errorMap[errorCode], valid);
				}else{
					ngModel.$setValidity('intl_tel', valid);
					console.log(iti.selectedCountryData);
					scope.disclosure.contactPhoneIso2 = iti.selectedCountryData.iso2;
					scope.disclosure.contactPhoneDialCode = iti.selectedCountryData.dialCode;
				}
				return valid ? value : undefined;
			});

			//For model -> DOM validation
			// ngModel.$formatters.unshift(function(value) {
			// 	for(var i=0; i<=4; i++) {
			// 		ngModel.$setValidity(errorMap[i], true);
			// 	}
            //
			// 	var valid = iti.isValidNumber();
			// 	if(!valid) {
			// 		var errorCode = iti.getValidationError();
			// 		errorCode = errorCode == -99 ? 0 : errorCode;
			// 		console.log("ec: " + errorCode);
			// 		ngModel.$setValidity(errorMap[errorCode], valid);
			// 	}else{
			// 		ngModel.$setValidity('intl_tel', valid);
			// 	}
			// 	return value;
			// });
		}
	};
});