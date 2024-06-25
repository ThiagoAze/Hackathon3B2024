/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function (knex) {
    //Chave estrangeira da tabela agenda
    return knex.schema.table('agenda', function (table) {
        //campo idAgenteSaude

        table.integer('idAgenteSaude').unsigned();
        table.foreign('idAgenteSaude').references('id').inTable('agentesaude');

        //campo idIdoso
        table.integer('idIdoso').unsigned();
        table.foreign('idIdoso').references('id').inTable('idoso');

        //campo idVacina
        table.integer('idVacina').unsigned();
        table.foreign('idVacina').references('id').inTable('vacina');
    });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function (knex) {
    //reverter dados modificados
    return knex.schema.table('agenda', function(table) {
        //reverter idAgenteSaude
        table.dropForeign('idAgenteSaude');
        table.dropColumn('idAgenteSaude');

        //reverter idIdoso
        table.dropForeign('idIdoso');
        table.dropForeign('idIdoso');
        
        //reverter idVacina
        table.dropForeign('idVacina');
        table.dropColumn('idVacina');
      });


};
