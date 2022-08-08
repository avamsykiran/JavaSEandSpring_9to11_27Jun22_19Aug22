package com.cts.spring.boot.data.jpa.demo.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cts.spring.boot.data.jpa.demo.entity.Txn;
import com.cts.spring.boot.data.jpa.demo.entity.TxnType;
import com.cts.spring.boot.data.jpa.demo.service.TxnService;

@Component
public class TxnUI implements ApplicationRunner {

	@Autowired
	private TxnService txnService;

	@Autowired
	private DateTimeFormatter dtFormatter;

	@Autowired
	private Scanner kbin;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Menu menu = null;
		Menu[] menus = Menu.values();

		while (menu != Menu.QUIT) {
			System.out.println("Menus");
			Arrays.stream(menus).map(m -> m.ordinal() + "\t" + m).forEach(System.out::println);
			System.out.print("Choice: ");
			int ch = kbin.nextInt();

			if (ch < 0 || ch >= menus.length) {
				System.out.println("Invlaid Choice");
				continue;
			}

			menu = menus[ch];

			switch (menu) {
			case LIST:
				doList();
				break;
			case ADD:
				doAdd();
				break;
			case DELETE:
				doDelete();
				break;
			case QUIT:
				System.out.println("App Terminated!");
				break;
			}
		}
	}

	private void doList() {
		List<Txn> txns = txnService.getAll();
		
		if(txns.isEmpty()) {
			System.out.println("No records to display");
		}else {
			txns.stream().forEach(System.out::println);
		}
			
	}

	private void doAdd() {
		Txn txn = new Txn();
		
		System.out.print("Desp: ");
		txn.setDescription(kbin.next());
		System.out.print("Date(dd-MM-yy): ");
		txn.setTxnDate(LocalDate.parse(kbin.next(),dtFormatter));
		System.out.print("Txn Type(CREDIT|DEBIT): ");
		txn.setType(TxnType.valueOf(kbin.next()));
		System.out.print("Amount: ");
		txn.setAmount(kbin.nextDouble());
		
		txnService.add(txn);
	}

	private void doDelete() {
		System.out.println("TxnId: ");
		long txnId = kbin.nextLong();
		
		txnService.remove(txnId);
	}
	

}
