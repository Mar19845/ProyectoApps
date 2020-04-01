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

const PORT = process.env.PORT || 5000;

app.listen(PORT, () => console.log(`Server started on Port ${PORT}`));