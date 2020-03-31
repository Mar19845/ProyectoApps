const express = require('express');
const app = express();

app.get('/', (req, res)=>{
    res.send('Prueba');
});

app.get('/tutores', (req, res)=>{
    res.send('tutores');
});

app.get('/usuario', (req, res)=>{
    res.send('tutores');
});

const PORT = process.env.PORT || 5000;

app.listen(PORT, () => console.log(`Server started on Port ${PORT}`));