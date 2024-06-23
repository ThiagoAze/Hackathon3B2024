/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela idoso\
    return knex.schema.createTable('idoso', function(table) {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('cpf', 11).notNullable();
        table.date('dataNascimento').notNullable();
        table.string('telefone', 11).notNullable();
        table.string('email', 100).notNullable();
        table.string('senha', 100).notNullable();
        table.string('genero', 2).notNullable();
        table.boolean('acompanhante').notNullable;
        table.timestamps(true, true).defaultTo(knex.fn.now());
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.dropTableIfExists('idoso');
};
