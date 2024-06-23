/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
   //Chave estrangeira da tabela problemasaude
   return knex.schema.table('problemasaude', function (table) {
    //campo idProblemaSaude

    table.integer('idProblemaSaude').unsigned();
    table.foreign('idProblemaSaude').references('id').inTable('problemasaude');
});
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
     //reverter dados modificados
     return knex.schema.table('problemasaude', function(table) {

        //reverter idHistoricoSaude
        table.dropForeign('idProblemaSaude');
        table.dropColumn('idProblemaSaude');
      });
  
};
