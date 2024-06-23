const path = require('path')

  module.exports = {
    client: 'mysql',
    connection: {
      host: '127.0.0.1',
      user: 'root',
      password: '',
      database: 'vacinet',
      charset: 'utf8mb4'
  },
  migrations: {
    directory: path.resolve(
      __dirname,
      'src',
      'database',
      'knex',
      'migrations'
    )
  }
}
