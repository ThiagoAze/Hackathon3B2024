/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Chave estrangeira da tabela diadisponivel
  return knex.schema.table('diadisponivel', function (table) {
      //campo idAgenteSaude

    table.integer('idAgenteSaude').unsigned();
    table.foreign('idAgenteSaude').references('id').inTable('agentesaude');
});
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
   //reverter dados modificados
   return knex.schema.table('diadisponivel', function(table) {

    //reverter idAgenteSaude
    table.dropForeign('idAgenteSaude');
    table.dropColumn('idAgenteSaude');
  });
  
};
