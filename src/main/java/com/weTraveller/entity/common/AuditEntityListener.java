package com.weTraveller.entity.common;

import com.weTraveller.security.SpringSecurityUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditEntityListener {
	private static final Logger log = (Logger) LoggerFactory.getLogger(AuditEntityListener.class);

	@Autowired
	private SpringSecurityUtil springSecurityUtil;

	@PrePersist
	public void prePersist(CommonColumn e) {
		try {
			if (e.getCreatedBy() == 0) {
				e.setCreatedBy(springSecurityUtil.getLoggedUserId());
				e.setUpdatedBy(springSecurityUtil.getLoggedUserId());
			}
			if (e.getCreatedAt() == null) {;
			}
		} catch (Exception ex) {
			log.error("Exception in Audit Entity Listener", ex);
		}
	}

	
	@PreUpdate
	public void preUpdate(CommonColumn e) {
		try {
			if (e.getUpdatedBy() == 0) {
				e.setUpdatedBy(springSecurityUtil.getLoggedUserId());
			}
			if (e.getUpdatedAt() == null) {
			}
		} catch (Exception ex) {
			log.error("Exception in Audit Entity Listener", ex);
		}
	}
}
