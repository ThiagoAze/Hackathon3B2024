 <div class="form-idoso">
    <div class="logo">Vacinet</div>
    <h1>Agendamento da vacinação</h1>

    <form action="validar/agenda" method="POST">

        <div class="row">
            <div class="col">
                <label for="data-agenda">Agende um dia de sua preferência:</label>
                <input type="date" name="data-agend" require id="data-agend" class="form-control" placeholder="dd/mm/aaaa">
            </div>
            <div class="col">
                <label for="periodo-agend">Agende em um dos horários de sua preferência</label>
                <select name="periodo-agend" require id="periodo-agend" class="form-select" aria-label="Default select example">
                    <option value="manha">Manhã: Entre ás 7:00 e 12:00</option>
                    <option value="tarde">Tarde: Entre ás 13:00 e 18:00</option>
                </select>            
            </div>
        </div>
        <br>

        <h2 class="vacina">Vacina agendada: <span class="nome-vacina">exemplo</span></h2>
        
        <div class="row">
            <div class="col">
                <button class="botao-voltar" type="submit" name="botao-voltar" value="botao-voltar">Voltar</button>
            </div>
            <div class="col">
                <button class="botao-confirmar" type="submit" name="botao-confirmar" value="botao-confirmar">Confirmar</button>
            </div>
        </div>
    </form>
</div>