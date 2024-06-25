/**
 * @param { import("knex").Knex } knex
 * 
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela agenda
    return knex.schema.createTable("agenda",(table) => {
        table.increments('id').primary();
        table.date('data').notNullable();
        table.time('horario').nullable();
        table.string('rua', 100).notNullable();
        table.string('cep', 8).notNullable();
        table.integer('numero').notNullable();
        table.string('complemento', 100).notNullable();
        table.string('cidade', 100).notNullable();
        table.string('estado', 100).notNullable();
        table.boolean('statusAgendamento').notNullable();
        table.string('periodo', 11).notNullable();
        table.boolean('statusVisita').notNullable();
        table.timestamp('created_At').defaultTo(knex.fn.now());
        table.timestamp('updated_At').defaultTo(knex.fn.now());
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.table('agenda', function(table) {
    table.dropColumn('id');
    table.dropColumn('data');
    table.dropColumn('horario');
    table.dropColumn('rua');
    table.dropColumn('cep');
    table.dropColumn('numero');
    table.dropColumn('complemento');
    table.dropColumn('cidade');
    table.dropColumn('estado');
    table.dropColumn('statusAgendamento');
    table.dropColumn('periodo');
    table.dropColumn('statusVisita');
  });
};
