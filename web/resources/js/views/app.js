var app = angular.module('app', []);

app.controller('FilmeController', ['$scope', '$http', '$location', function ($scope, $http, $location) {
        $scope.filme = [];
        $scope.summaryError = false;
        $scope.erroMessage = [];
        $scope.filmeList = [];
        $scope.url = "http://localhost:8080/ProjetoCinemaWeb-master/";

        $scope.consultarFilmesCadastrados = function () {
            $http.get($scope.url + 'webresources/filmes')
                    .success(function (data) {
                        $scope.filmeList = data;
                    }).error(function (data) {
                        alert(data.toString());
                    });
        };

        $scope.salvar = function () {
            $scope.summaryError = true;

            if ($scope.validForm()) {
                var filmeParam =
                        {
                            ano: $scope.filme.ano,
                            diretor: $scope.filme.diretor,
                            genero: $scope.filme.genero,
                            id: 0,
                            nome: $scope.filme.nome,
                            sinopse: $scope.filme.sinopse
                        };

                console.log(filmeParam);

                $http({
                    method: 'POST',
                    data: filmeParam,
                    url: $scope.url + 'webresources/filmes',
                    headers: {'Content-Type': 'application/json'}
                }).success(function (data, status, headers, config) {
                    console.log(data);
                    alert('Filme Salvo com sucesso...');
                    $scope.filme = [];
                }).error(function (data, status, headers, config) {
                    console.log(data);
                    alert('Erro ao salvar filme: ' + data.toString());
                });
            }

        };

        $scope.validForm = function () {
            var result = false;
            $scope.erroMessage = [];

            if ($scope.form.$valid) {
                result = true;
            } else {
                if ($scope.form.txtNome.$error.required) {
                    $scope.erroMessage.push('Informe o nome do filme.');
                }
                if ($scope.form.cbGenero.$error.required) {
                    $scope.erroMessage.push('Informe o gênero do filme.');
                }
                if ($scope.form.txtAno.$error.required) {
                    $scope.erroMessage.push('Informe o ano do filme.');
                }
                if ($scope.form.txtNomeDiretor.$error.required) {
                    $scope.erroMessage.push('Informe o nome do diretor do filme.');
                }
                if ($scope.form.txtSinopse.$error.required) {
                    $scope.erroMessage.push('Informe a sinopse do filme.');
                }
            }

            return result;
        };

        $scope.init = function () {
            $scope.consultarFilmesCadastrados();
        };

        $scope.init();
    }]);


/*
 var response = $http.post(url, $scope.filme);
 response.success(function (data) {
 }).error(function (data) {
 alter(data);
 }).finally(function () {
 });
 */