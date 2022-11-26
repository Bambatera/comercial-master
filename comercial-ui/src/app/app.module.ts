import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { registerLocaleData } from '@angular/common';
import ptBr from '@angular/common/locales/pt';

import { TableModule } from 'primeng/table';
import { PanelModule } from 'primeng/panel';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

import { AppComponent } from './app.component';
import { PainelNegociacaoComponent } from './painel-negociacao/painel-negociacao.component';

registerLocaleData(ptBr);

@NgModule({
	declarations: [
		AppComponent,
		PainelNegociacaoComponent
	],
	imports: [
		BrowserModule,
		BrowserAnimationsModule,
		FormsModule,
		HttpClientModule,
		TableModule,
		PanelModule,
		InputTextModule,
		ButtonModule,
		ToastModule
	],
	providers: [
		MessageService,
		{ provide: LOCALE_ID, useValue: 'pt' }
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
