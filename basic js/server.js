const express = require('express')
const bcrypt = require('bcrypt')

const app = express()
app.use( express.json() )

const users = []

app.get('/users' , async (req , res) => {
    
    // const salt = await bcrypt.genSalt()
    try{
        const salt = await bcrypt.genSalt( 10 );
        const hashed = await bcrypt.hash( req.body.password , salt )
        console.log( hashed )
        const user = { name : req.body.name , password : req.body.password }
        users.push( user )
        res.status( 201 ).send()
    }catch{}

})


app.listen(3000)

