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
/**
 * This is a processor class which contains the processing business logic, after reading the input and before passing it to writer for writing to the file/database.. 
 * 
 * @author Bhagyashri Niphade
 */
@Component
public class CollectionProcessor implements ItemProcessor<Contract, Collection> {

	Logger log = LoggerFactory.getLogger(CollectionProcessor.class);
	private AtomicInteger count = new AtomicInteger();

	@Autowired
	private Product product;

	@Autowired
	private ProductRepository productrepository;

	/**
	 * Processes the business logic on the data read from reader.
	 * 
	 * @param contract Contract details wrapped in {@link Contract}.
	 * @return Collection Collection details wrapped in {@link Collection}.
	 */
	@Override
	public Collection process(Contract contract) {

		//current date
		LocalDate date = LocalDate.now();
		date = date.plusMonths(1);
		if (contract.getCollectionday() == date.getDayOfMonth()) {
			log.info("processing the data " + contract.getId() + " Record No :" + count.incrementAndGet());
			
			Collection collection = new Collection();
			collection.setClientnumber(contract.getClientnumber());
			String searchPremium = contract.getProductCode();
			product = productrepository.getProductByProductCode(searchPremium);
			collection.setPremium(product.getPremium());
			collection.setCollectiondate(date.format(DateTimeFormatter.ofPattern("dd/MM/uuuu")));
			return collection;
		}
		return null;
	}

}
