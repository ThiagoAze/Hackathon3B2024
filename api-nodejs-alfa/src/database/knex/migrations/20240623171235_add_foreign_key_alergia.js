/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
     //Chave estrangeira da tabela alergia
     return knex.schema.table('alergia', function (table) {
         //campo idHistoricoSaude

        table.integer('idIdoso').unsigned();
        table.foreign('idIdoso').references('id').inTable('idoso');
    });  
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
    //reverter dados modificados
    return knex.schema.table('alergia', function(table) {

        //reverter idHistoricoSaude
        table.dropForeign('idHistoricoSaude');
        table.dropColumn('idHistoricoSaude');
      });
};
