const express = require('express');
const app = express();
const fs = require('fs');

let rawdata = fs.readFileSync('Database/database.json');
let database = JSON.parse(rawdata);

app.get('/', (req, res)=>{
    res.send('Prueba');
});

app.get('/tutores', (req, res)=>{
    var usuarios = database.users;
    var tutores = {"users":[]}
    for(i in usuarios){
        usuario = usuarios[i];
        if(usuario.tipo){
            tutores.users.push(usuario);
        }
    }

    res.send(JSON.stringify(tutores));
});

app.get('/usuarios', (req, res)=>{
    res.send(database);
});

app.get('/usuarios/:id', (req, res)=>{
    var usuarios = database.users;
    var usuario1 = {}
    for(i in usuarios){
        usuario = usuarios[i];
        if(usuario.id == req.params.id){
            usuario1 = usuario
        }
    }
    res.send(JSON.stringify(usuario1));
});
app.get('/usuarios/:cursos', (req, res)=>{
    var usuarios = database.users;
    var usuario1 =  {"users":[]}
    for(i in usuarios){
        usuario = usuarios[i];
        if(usuario.cursos == req.params.cursos){
            usuario1.users.push(usuario)
        }
    }
    res.send(JSON.stringify(usuario1));
});

    res.send(JSON.stringify(usuario1));
});

const PORT = process.env.PORT || 5000;

app.listen(PORT, () => console.log(`Server started on Port ${PORT}`));