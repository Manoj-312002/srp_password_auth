const seedrandom = require('seedrandom');
const bcrypt = require('bcrypt')

const password = "4443354h"
const cleartext = "1fe355795ce746ec89e07e7236700297"

function XOR_hex(a, b) {
    var res = "",
        i = a.length,
        j = b.length;
    while (i-->0 && j-->0)
        res = (parseInt(a.charAt(i), 16) ^ parseInt(b.charAt(j), 16)).toString(16) + res;
    return res;
}

var imgurl = "https://scx2.b-cdn.net/gfx/news/hires/2016/howsunflower.jpg";

const generator = seedrandom('xyz123');
const seed1 = generator();
const seed2 = generator();
const seed3 = generator();

bcrypt.hash(password, seed1, function(err, hash) {

    console.log(hash)
    const tstring = XOR_hex(cleartext,hash)
    console.log(tstring)
    var ascii = "";
    for(var i = 0; i<tstring.length; i++){
            ascii+= tstring.charCodeAt(i);
    }
    console.log(ascii)
    
});

// console.log(seed1)
// console.log(seed2)
// console.log(seed3)

