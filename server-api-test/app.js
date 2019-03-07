const http = require('http');
var fs = require('fs');

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
    res.statusCode = 200;
    //res.setHeader('Content-Type', 'text/plain');
     let rawdata = fs.readFileSync('data.json');
  
    res.end(rawdata);
    //res.end('Hello World\n');
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});