import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { OportunidadeService } from '../oportunidade.service';

@Component({
	selector: 'app-painel-negociacao',
	templateUrl: './painel-negociacao.component.html',
	styleUrls: ['./painel-negociacao.component.css']
})
export class PainelNegociacaoComponent implements OnInit {

	public oportunidade: any = {};
	public oportunidades = [];

	constructor(
		private oportunidadeService: OportunidadeService,
		private messageService: MessageService,
	) { }

	public ngOnInit(): void {
		this.consultar();
	}
	
	public consultar() {
		this.oportunidadeService.listar().subscribe(
			resposta => this.oportunidades = <any> resposta
		);
	}

	public adicionar() {
		this.oportunidadeService.adicionar(this.oportunidade).subscribe(() => {
			this.messageService.add({
				severity: "success",
				summary: "Oportunidade adicionada com sucesso!"
			});
			
			this.oportunidade = {};
			this.consultar();
		}, onError => {
			let msgError = "Erro inesperado. Contate o suporte técnico!"
			
			if (onError.error.message) {
				msgError = onError.error.message;
			}

			this.messageService.add({
				severity: "error",
				summary: msgError
			});
		});
	}
}
