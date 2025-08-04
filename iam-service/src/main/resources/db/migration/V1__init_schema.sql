CREATE TABLE IF NOT EXISTS users (
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email TEXT NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,

    authorities TEXT NOT NULL,

    is_enabled BOOLEAN NOT NULL,
    is_account_non_expired BOOLEAN NOT NULL,
    is_account_non_locked BOOLEAN NOT NULL,
    is_credentials_non_expired BOOLEAN NOT NULL,

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE outbox_events (
   id UUID PRIMARY KEY,
   aggregate_type VARCHAR(100) NOT NULL,
   aggregate_id VARCHAR(100) NOT NULL,
   event_type VARCHAR(100) NOT NULL,
   payload JSONB NOT NULL,
   status VARCHAR(20) NOT NULL,
   created_at TIMESTAMP NOT NULL,
   locked_at TIMESTAMP NULL,
   published_at TIMESTAMP NULL,
   retry_count INT NOT NULL,
   error TEXT NULL
);

