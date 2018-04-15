# Adiciona vetor de tags nos produtos

## Compilação e empacotamento:

`mvn clean package assembly:single`

Será gerada a pasta `target` com os arquivos para execução

## Execução:

Acessar a pasta `target`

Executar: `java -cp add-tags-vector.jar AdicionaVetorTags <caminho absoluto para o arquivo de produtos>`

## Resultado:

Na pasta `target`

Será gerado um arquivo chamado `produtos-processados.txt`