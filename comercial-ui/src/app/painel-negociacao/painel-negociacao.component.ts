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

	public alterar(oprtnd: any) {
		this.oportunidade = oprtnd;
	}

	public remover(id: number) {
		this.oportunidadeService.remover(id).subscribe(() => {
			this.messageService.add({
				severity: "success",
				summary: "Oportunidade excluída com sucesso!"
			});
			
			this.limpar();
			this.consultar();
		});
	}

	public limpar() {
		this.oportunidade = {}
	}

	public salvar() {
		if (this.oportunidade.id) {
			this.oportunidadeService.alterar(this.oportunidade).subscribe(() => {
				this.messageService.add({
					severity: "success",
					summary: "Oportunidade alterada com sucesso!"
				});
				
				this.limpar();
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
		} else {
			this.oportunidadeService.adicionar(this.oportunidade).subscribe(() => {
				this.messageService.add({
					severity: "success",
					summary: "Oportunidade adicionada com sucesso!"
				});
				
				this.limpar
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
}
