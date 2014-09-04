package com.force.api;

public interface TokenRenewalObserver {
	public void tokenAboutToChange();
	public void tokenRenewedSuccessfully(ApiSession session);
	public void tokenNotRenewedSuccessfully();
}
