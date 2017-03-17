'use strict';

const env = require('./env');
const fs = require('fs');
const http = require('http');
const https = require('https');

function createHttpsServer (app) {
  const key  = fs.readFileSync(`${env.SSL_CERT_DIR}/server.key`, 'utf8');
  const cert = fs.readFileSync(`${env.SSL_CERT_DIR}/server.crt`, 'utf8');

  return https.createServer({key, cert}, app);
}


function createHttpServer (app) {
  return http.createServer(app);
}


module.exports = function (app) {
  if (env.SSL_ENABLED) { return createHttpsServer(app); }

  return createHttpServer(app);
};
