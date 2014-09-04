package com.force.api;

public interface TokenRenewalObserver {
	public void tokenNeedsRenewal(String oldSyncToken,String refreshToken);
	public void tokenRenewedSuccessfully(ApiSession session);
	public void tokenNotRenewedSuccessfully();
}
