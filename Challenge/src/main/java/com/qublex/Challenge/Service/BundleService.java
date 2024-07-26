package com.qublex.Challenge.Service;

import com.qublex.Challenge.Entity.Bundle;

public interface BundleService {
    int calculateMaxBundleNumber(String designation) throws Exception;

    Bundle createBundle(Bundle bundle);
}
