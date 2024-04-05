# Test Queries:

1. Open the project ```Applo``` in your IDE e.g. Intellij IDEA
2. Make sure that port nr ```9091``` is available or change it in ```application.properties``` file
3. On a browser window, open the GraphQL playground via ```http://localhost:9091/graphiql```. 
4. The browser will ask you to enter a username/password. We have defined two users ```user``` and ```admin``` in ```SecurityConfig``` and feel free to add more if needed. 
5. The ```user``` is limited to run only ```allBook``` query. If you have logged in as a ```user/password``` then try to run the following query:

```
query findAllBook {
  allBook {
    id
    name
    genre
  }
}
```
The response is:
```
{
  "data": {
    "allBook": [
      {
        "id": "1",
        "name": "Night",
        "genre": "FICTION"
      },
      {
        "id": "2",
        "name": "Day",
        "genre": "SCIENCE"
      },
      {
        "id": "3",
        "name": "Afternoon",
        "genre": "HISTORY"
      }
    ]
  }
}
```
BUT if you try to run this query:
```
mutation createBook {
	createBook(name:"Cool Down", genre:HISTORY) {
    id
    name
    genre
  }
}
```
then you will get a ```Forbidden``` message. You can run this query only if you have logged in as an ```admin```

Try to run this query as a ```user``` and then as an ```admin``` and compare the results: 

```
query findAllOrders{
  findAllOrders {
    orderId
    orderedOn
    book {
      id
      name
      genre
    }
  }
}
```

> Note: There are some other commented queries in ```schema.graphqls``` and if you want to use them then you should uncomment the associated business logic in the ```BookController.java``` and try the below queries: 

```
query {
  findAll {
    id
    name
    genre
  }
}

query {
  findOne(id:1) {
    id
    name
    genre
  }
}

mutation {
  create(name:"Essentialism", genre:HISTORY){
    id
    name
    genre
  }
}

mutation {
  update(id:1,name:"Get Rich",genre:FICTION){
    id
    name
    genre
  }
}

mutation {
  delete(id:2){
    id
    name
    genre
  }
}
```
