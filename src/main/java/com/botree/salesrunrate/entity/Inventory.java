package com.botree.salesrunrate.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventory")

public class Inventory extends MongoEntity {
		private static final long serialVersionUID = 1L;
		@Id
		private String prdName;
		private String prdCode;
		private String qty;
		
		public String getPrdName() {
			return prdName;
		}

		public void setPrdName(String prdName) {
			this.prdName = prdName;
		}

		public String getPrdCode() {
			return prdCode;
		}

		public void setPrdCode(String prdCode) {
			this.prdCode = prdCode;
		}

		
		public String getQty() {
			return qty;
		}

		public void setQty(String qty) {
			this.qty = qty;
		}

	}

