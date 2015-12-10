var app = angular.module('app',[]);

app.controller('FilmeController', ['$scope', function($scope) {
	$scope.filme = [];
	$scope.summaryError = false;
	$scope.erroMessage = [];
	$scope.filmeList = [];

	$scope.salvar = function(filme){
		$scope.summaryError = true;

		if($scope.validForm()){
			var url = '';

			$scope.filmeList.push($scope.filme);

			$scope.filme = [];

			alert('Filme Salvo com sucesso...');
		}

	};

	$scope.validForm = function(){
		var result = false;
		$scope.erroMessage = [];

		if($scope.form.$valid){
			result = true;
		}else{
			if($scope.form.txtNome.$error.required){
				$scope.erroMessage.push('Informe o nome do filme.');
			}
			if($scope.form.cbGenero.$error.required){
				$scope.erroMessage.push('Informe o gênero do filme.');
			}
			if($scope.form.txtAno.$error.required){
				$scope.erroMessage.push('Informe o ano do filme.');
			}
			if($scope.form.txtNomeDiretor.$error.required){
				$scope.erroMessage.push('Informe o nome do diretor do filme.');
			}
			if($scope.form.txtSinopse.$error.required){
				$scope.erroMessage.push('Informe a sinopse do filme.');
			}
		}

		return result;
	};
}]);


/*
			var response = $http.post(url, $scope.filme);
			response.success(function (data) {
			}).error(function (data) {
				alter(data);
			}).finally(function () {
			});
*/