# Kotlin, DevOps e Cloud Native - Alura

Projeto de estudo do curso de Kotlin CloudNative da Alura.

## Curso

- [Aprofunde em Kotlin e DevOps com uma aplicação Cloud Native](https://cursos.alura.com.br/formacao-cloud-native-kotlin)

## Tópicos abordados

- Retrofit
- Circuit Breaker
- Coroutines
- Testes com Kotest

## Rodando o projeto

Adicionei um arquivo `docker-compose.yml` para facilitar a execução do projeto. Para rodar o projeto, basta executar o
comando abaixo:

```bash
docker-compose up -d
```

## Levando a imagem para o Docker Hub

Para levar a imagem para o Docker Hub, basta executar o comando abaixo:

```bash
docker image build -t car-service:v1 .
docker tag sha256:249a6ef40b2a039b71e0e40d763e44ea3e0442dd86aa478a998fc3027a7f3139 jjeanjacques10/car-service:v1
docker push jjeanjacques10/car-service:v1
```

> Resultado: https://hub.docker.com/repository/docker/jjeanjacques10/car-service/

## Referências

- [Resilience4J](https://resilience4j.readme.io/docs)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-basics.html)

## Notas

- Para adicionar as Coroutines precisa importar a dependência `kotlinx-coroutines-core` e `kotlinx-coroutines-jdk8`

---
Desenvolvido por [Jean Jacques Barros](https://github.com/jjeanjacques10)