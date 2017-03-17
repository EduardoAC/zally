'use strict';

const env = require('./env');
const logger = require('./logger');
const request = require('request');

module.exports = function (req, res) {
  const url = env.ZALLY_API_URL + req.url.replace('/zally-api', '');
  logger.debug(`Proxying request to: ${url}`);
  req.pipe(request(url)).pipe(res);
};
