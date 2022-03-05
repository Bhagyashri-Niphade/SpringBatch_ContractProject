package com.spring.batch.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.batch.entity.*;
import com.spring.batch.repository.ProductRepository;

@Component
//ItemProcessr file to process data from Contract (input)table and set it in Collection (output)table
public class Myprocessor implements ItemProcessor<Contract, Collection> {

	Logger log = LoggerFactory.getLogger(Myprocessor.class);

	private AtomicInteger count = new AtomicInteger();

	@Autowired
	private Product product;

	@Autowired
	private ProductRepository productrepository;

	@Override
	public Collection process(Contract contract) throws Exception {

		//current date
		LocalDate date = LocalDate.now();
		date = date.plusMonths(1);	//adding one month in current date

		//if todays date is match with collectionday available in Contract table
		if (contract.getCollectionday() == date.getDayOfMonth()) {
			log.info("processing the data " + contract.getId() + " Record No :" + count.incrementAndGet());
			
			Collection collection = new Collection();
			collection.setClientnumber(contract.getClientnumber());

			//retrive productcode from contract
			String searchPremium = contract.getProductCode();
			product = productrepository.getProductByProductCode(searchPremium);
			
			//accessing premium from product table whose productcode is match with searchpremium
			collection.setPremium(product.getPremium());
			
			//format date and convert it into String
			collection.setCollectiondate(date.format(DateTimeFormatter.ofPattern("dd/MM/uuuu")));
			return collection;
		}
		return null;
	}

}
